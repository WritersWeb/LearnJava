const roadmap = [
  { week: 1, days: ['Hello World', 'Variables & I/O', 'Operators', 'Conditionals', 'Loops', 'Arrays & Strings', 'Project Day'] },
  { week: 2, days: ['Classes & Objects', 'Constructors & Encapsulation', 'Inheritance', 'Exceptions', 'File I/O', 'Revision', 'Project Day'] },
  { week: 3, days: ['Setup Dart', 'Variables & Control Flow', 'Functions & Null Safety', 'Collections', 'Dart Objects', 'Async Basics', 'Project Day'] },
  { week: 4, days: ['Install Flutter', 'Project Structure', 'Stateless vs Stateful', 'Layouts', 'Widgets', 'Forms', 'Project Day'] },
  { week: 5, days: ['Navigation', 'Dynamic Lists', 'HTTP & JSON', 'Firebase Auth', 'Firestore CRUD', 'State Mgmt', 'Project Day'] },
  { week: 6, days: ['Theming', 'Animations', 'Form Validation', 'Testing', 'Deployment', 'Wrap Up', 'Project Day'] },
];

const savedProgress = JSON.parse(localStorage.getItem('progress')) || {};
const savedSubmissions = JSON.parse(localStorage.getItem('submissions')) || {};

function updateProgressBar() {
  const total = roadmap.length * 7;
  const completed = Object.values(savedProgress).filter(Boolean).length;
  const percent = Math.round((completed / total) * 100);
  const fill = document.getElementById('progress-fill');
  fill.style.width = `${percent}%`;
  fill.textContent = `${percent}%`;
}

function renderRoadmap() {
  const container = document.getElementById('roadmap');
  container.innerHTML = '';

  roadmap.forEach(({ week, days }, wIndex) => {
    const weekDiv = document.createElement('div');
    weekDiv.className = 'week';
    weekDiv.innerHTML = `<h3>Week ${wIndex + 1}</h3>`;

    days.forEach((day, dIndex) => {
      const key = `${wIndex + 1}-${dIndex}`;
      const checked = savedProgress[key] ? 'checked' : '';
      const submission = savedSubmissions[key] || '';

      const dayDiv = document.createElement('div');
      dayDiv.className = 'day-item';
      dayDiv.innerHTML = `
        <label>
          <input type="checkbox" id="check-${key}" ${checked} />
          ${day}
        </label>
        <div class="submission-box">
          <input type="text" id="input-${key}" placeholder="Submit notes or assignment…" value="${submission}" />
          <button id="btn-${key}">Save</button>
        </div>
        <div class="submission-list" id="list-${key}">${submission ? 'Submitted: ' + submission : ''}</div>
      `;

      // Checkbox logic
      dayDiv.querySelector(`#check-${key}`).addEventListener('change', (e) => {
        savedProgress[key] = e.target.checked;
        localStorage.setItem('progress', JSON.stringify(savedProgress));
        updateProgressBar();
      });

      // Submission logic
      dayDiv.querySelector(`#btn-${key}`).addEventListener('click', () => {
        const val = dayDiv.querySelector(`#input-${key}`).value.trim();
        savedSubmissions[key] = val;
        localStorage.setItem('submissions', JSON.stringify(savedSubmissions));
        dayDiv.querySelector(`#list-${key}`).textContent = val ? 'Submitted: ' + val : '';
      });

      weekDiv.appendChild(dayDiv);
    });

    container.appendChild(weekDiv);
  });

  updateProgressBar();
}

renderRoadmap();

function renderTodayFocus() {
  const startDate = new Date("2025-09-29"); // Monday of Week 1
  const today = new Date();
  const diffDays = Math.floor((today - startDate) / (1000 * 60 * 60 * 24));
  const weekIndex = Math.floor(diffDays / 7);
  const dayIndex = diffDays % 7;

  const focusDiv = document.getElementById('focus-content');

  if (weekIndex >= 0 && weekIndex < roadmap.length) {
    const week = roadmap[weekIndex];
    const day = week.days[dayIndex];
    const key = `${weekIndex + 1}-${dayIndex}`;
    const checked = savedProgress[key] ? 'checked' : '';
    const submission = savedSubmissions[key] || '';

    focusDiv.innerHTML = `
      <strong>Week ${weekIndex + 1}, Day ${dayIndex + 1}:</strong> ${day.title}<br/>
      <em>${day.desc}</em><br/><br/>
      <label>
        <input type="checkbox" id="focus-check" ${checked}/> Mark as done
      </label><br/>
      <input type="text" id="focus-input" placeholder="Submit today’s notes…" value="${submission}" />
      <button id="focus-btn">Save</button>
      <div id="focus-status">${submission ? 'Submitted: ' + submission : ''}</div>
    `;

    document.getElementById('focus-check').addEventListener('change', (e) => {
      savedProgress[key] = e.target.checked;
      localStorage.setItem('progress', JSON.stringify(savedProgress));
      updateProgressBar();
    });

    document.getElementById('focus-btn').addEventListener('click', () => {
      const val = document.getElementById('focus-input').value.trim();
      savedSubmissions[key] = val;
      localStorage.setItem('submissions', JSON.stringify(savedSubmissions));
      document.getElementById('focus-status').textContent = val ? 'Submitted: ' + val : '';
    });
  } else {
    focusDiv.innerHTML = "You're outside the 6-week roadmap range.";
  }
}

renderRoadmap();
renderTodayFocus();