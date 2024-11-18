function showSection(sectionId) {
    // Hide all content sections
    const contents = document.querySelectorAll('.content');
    contents.forEach(content => {
        content.classList.remove('active');
    });

    // Show the specified section
    const sectionToShow = document.getElementById(sectionId);
    if (sectionToShow) {
        sectionToShow.classList.add('active');
    }

    // Update the active link
    const navLinks = document.querySelectorAll('.navLinks a');
    navLinks.forEach(link => {
        link.classList.remove('active');
    });

    const activeLink = document.querySelector(`.navLinks a[onclick="showSection('${sectionId}')"]`);
    if (activeLink) {
        activeLink.classList.add('active');
    }
}

// Show the home section by default
document.addEventListener('DOMContentLoaded', () => {
    const hash = window.location.hash.substring(1);
    showSection(hash || 'home');
});

// Handle hash changes
window.addEventListener('hashchange', () => {
    const hash = window.location.hash.substring(1);
    showSection(hash || 'home');
});

function toggleSidebar() {
    const sidebar = document.getElementById('sidebar');
    sidebar.classList.toggle('active');
}

// Close sidebar when clicking outside
document.addEventListener('click', function (event) {
    const sidebar = document.getElementById('sidebar');
    const hamburger = document.querySelector('.hamburger');

    if (!sidebar.contains(event.target) && !hamburger.contains(event.target)) {
        sidebar.classList.remove('active');
    }
});


function finishButton() {
    // Get the button element by its ID
    var button = document.getElementById("select");

    // Disable the button
    button.disabled = true;

    // Change the button text
    button.innerHTML = "Selected";
}


