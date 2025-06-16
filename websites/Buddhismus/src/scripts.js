document.addEventListener("DOMContentLoaded", function () {
    const navTitel = document.querySelector(".nav-titel");
    if (navTitel) {
        navTitel.style.cursor = "pointer";
        navTitel.addEventListener("click", function () {
            window.location.href = "index.html";
        });
    }

    const quellenButton = document.querySelector(".quellen-link");
    if (quellenButton) {
        quellenButton.style.cursor = "pointer";
        quellenButton.addEventListener("click", function () {
            window.location.href = "quellen.html";
        });
    }
});
