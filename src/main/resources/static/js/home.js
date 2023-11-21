function openMenu() {
	const toggleBtn = document.querySelector(".toggle_btn")
	const toggleBtnIcon = document.querySelector(".toggle_btn i")
	const dropDownMenu = document.querySelector(".dropdown_menu")

	toggleBtn.onclick = function() {
		dropDownMenu.classList.toggle("open")
		const isOpen = dropDownMenu.classList.contains("open")

		toggleBtnIcon.classList = isOpen
			? 'fa-solid fa-xmark'
			: 'fa-solid fa-bars'
	}
}

document.addEventListener("DOMContentLoaded", function() {
  const languageSelect = document.getElementById("language-select");

  languageSelect.addEventListener("change", function () {
    const selectedLanguage = languageSelect.value;
    window.location.href = selectedLanguage;
  });
});
