import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Main application class implementing the GUI using Java Swing.
 * This class handles the view, controls, and data management (File I/O).
 */
public class ContactGUI extends JFrame {
    
    // Data storage and persistence fields
    private List<Contact> contacts;
    private DefaultListModel<Contact> listModel;
    private JList<Contact> contactJList;
    private static final String FILE_NAME = "contacts.txt";

    // UI components
    private JTextField nameField, phoneField;
    private JButton addButton, deleteButton;

    public ContactGUI() {
        super("Simple Contact Manager");
        
        // 1. Initialize Data and Load Contacts
        this.contacts = new ArrayList<>();
        this.listModel = new DefaultListModel<>();
        loadContacts();

        // 2. Set up the main window (JFrame)
        setupFrame();

        // 3. Create and add UI panels
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        mainPanel.add(createInputPanel(), BorderLayout.NORTH);
        mainPanel.add(createListPanel(), BorderLayout.CENTER);
        mainPanel.add(createActionPanel(), BorderLayout.SOUTH);

        add(mainPanel);
        
        // 4. Final configuration and visibility
        this.pack();
        this.setLocationRelativeTo(null); // Center the window
        this.setVisible(true);
    }

    /**
     * Configures the main JFrame properties.
     */
    private void setupFrame() {
        // Handle closing the window
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        // Add a Window Listener to handle saving data on close (Exception Handling)
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(ContactGUI.this, 
                    "Are you sure you want to exit and save data?", "Close Application", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    saveContacts();
                    System.exit(0);
                }
            }
        });
    }

    /**
     * Creates the panel for Name and Phone input fields.
     */
    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 5));
        
        // Name Field
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField(20);
        inputPanel.add(nameField);

        // Phone Field
        inputPanel.add(new JLabel("Phone Number:"));
        phoneField = new JTextField(20);
        inputPanel.add(phoneField);
        
        // Add Button
        addButton = new JButton("Add Contact");
        addButton.setBackground(new Color(59, 130, 246)); // Tailwind blue-500 equivalent
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(this::addContact);
        inputPanel.add(new JLabel("")); // Placeholder for grid alignment
        inputPanel.add(addButton);

        return inputPanel;
    }

    /**
     * Creates the scrollable panel for the contact list.
     */
    private JPanel createListPanel() {
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(BorderFactory.createTitledBorder("Contact List"));
        
        contactJList = new JList<>(listModel);
        contactJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Allows the delete button to be enabled when an item is selected
        contactJList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                deleteButton.setEnabled(contactJList.getSelectedIndex() != -1);
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(contactJList);
        scrollPane.setPreferredSize(new Dimension(400, 250)); // Set preferred size for the list
        listPanel.add(scrollPane, BorderLayout.CENTER);
        
        return listPanel;
    }
    
    /**
     * Creates the panel for action buttons (like Delete).
     */
    private JPanel createActionPanel() {
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        deleteButton = new JButton("Delete Selected Contact");
        deleteButton.setBackground(new Color(239, 68, 68)); // Tailwind red-500 equivalent
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        deleteButton.setEnabled(false); // Initially disabled
        deleteButton.addActionListener(this::deleteContact);
        
        actionPanel.add(deleteButton);
        return actionPanel;
    }

    /**
     * Event handler for adding a new contact.
     */
    private void addContact(ActionEvent event) {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();

        if (name.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Name and Phone Number are required.", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Contact newContact = new Contact(name, phone);
        contacts.add(newContact);
        
        // Update the visual list model and clear fields
        updateListModel(); 
        nameField.setText("");
        phoneField.setText("");
        
        saveContacts();
        JOptionPane.showMessageDialog(this, "Contact added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Event handler for deleting the selected contact.
     */
    private void deleteContact(ActionEvent event) {
        int selectedIndex = contactJList.getSelectedIndex();
        if (selectedIndex != -1) {
            Contact contactToDelete = listModel.getElementAt(selectedIndex);
            
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete " + contactToDelete.getName() + "?", 
                "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                // Remove from both the ArrayList (data) and the ListModel (view)
                contacts.remove(contactToDelete);
                updateListModel();
                saveContacts();
                JOptionPane.showMessageDialog(this, "Contact deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Synchronizes the internal ArrayList with the visual JList model.
     * Also sorts the contacts alphabetically by name.
     */
    private void updateListModel() {
        // Sort the master list before updating the model
        contacts.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        
        listModel.clear();
        for (Contact c : contacts) {
            listModel.addElement(c);
        }
    }


    // --- File I/O (Persistence Logic) ---
    
    /**
     * Loads contacts from the text file into the list.
     */
    private void loadContacts() {
        File file = new File(FILE_NAME);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    // Create a new Contact object and add it to the list
                    contacts.add(new Contact(parts[0].trim(), parts[1].trim()));
                }
            }
            updateListModel(); // Populate the JList with loaded data
            System.out.println("Loaded " + contacts.size() + " contacts from file.");
        } catch (FileNotFoundException e) {
            System.out.println("No existing contact file found. Starting fresh.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(), 
                "I/O Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Saves all current contacts to the text file.
     */
    private void saveContacts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Contact contact : contacts) {
                writer.write(contact.toFileString());
                writer.newLine();
            }
            System.out.println("Contacts saved to file.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage(), 
                "I/O Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // --- Main Entry Point ---
    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread (Swing best practice)
        SwingUtilities.invokeLater(ContactGUI::new);
    }
}
