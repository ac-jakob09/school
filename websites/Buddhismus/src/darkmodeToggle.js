function createDarkModeToggle() {
    const header = document.querySelector(".nav-container");

    if (!header) {
        console.error("Navigation container not found");
        return;
    }

    const toggleWrapper = document.createElement("div");
    toggleWrapper.className = "theme-toggle-wrapper";

    const toggleButton = document.createElement("button");
    toggleButton.className = "theme-toggle";
    toggleButton.setAttribute("aria-label", "Toggle dark mode");
    toggleButton.setAttribute("title", "Toggle theme");

    const toggleCircle = document.createElement("div");
    toggleCircle.className = "toggle-circle";

    const iconContainer = document.createElement("div");
    iconContainer.className = "theme-icon";

    toggleCircle.appendChild(iconContainer);
    toggleButton.appendChild(toggleCircle);
    toggleWrapper.appendChild(toggleButton);

    header.insertBefore(toggleWrapper, header.firstChild);

    toggleButton.addEventListener("click", () => {
        toggleTheme();
    });
}

function toggleTheme() {
    const currentTheme = document.documentElement.getAttribute("data-theme");
    if (currentTheme === "dark") {
        document.documentElement.setAttribute("data-theme", "light");
        localStorage.setItem("theme", "light");
    } else {
        document.documentElement.setAttribute("data-theme", "dark");
        localStorage.setItem("theme", "dark");
    }
}

function initializeTheme() {
    const prefersDarkScheme = window.matchMedia("(prefers-color-scheme: dark)");
    const savedTheme = localStorage.getItem("theme");

    if (savedTheme === "dark" || (!savedTheme && prefersDarkScheme.matches)) {
        document.documentElement.setAttribute("data-theme", "dark");
    } else {
        document.documentElement.setAttribute("data-theme", "light");
    }
}

function addSystemThemeListener() {
    window.matchMedia("(prefers-color-scheme: dark)").addEventListener("change", (event) => {
        if (!localStorage.getItem("theme")) {
            document.documentElement.setAttribute("data-theme", event.matches ? "dark" : "light");
        }
    });
}

if (document.readyState !== "loading") {
    initializeTheme();
    createDarkModeToggle();
    addSystemThemeListener();
} else {
    document.addEventListener("DOMContentLoaded", function () {
        initializeTheme();
        createDarkModeToggle();
        addSystemThemeListener();
    });
}
