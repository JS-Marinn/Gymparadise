function openMenu(){
    const toggleBtn = document.querySelector(".toggle_btn")
    const toggleBtnIcon = document.querySelector(".toggle_btn i")
    const dropDownMenu = document.querySelector(".dropdown_menu")
            
    toggleBtn.onclick = function(){
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

// Validaciones del formulario
function validarFormulario() {
  // Nombre completo
  let name = document.getElementById("name").value;
  if (name === "") {
    alert("El nombre completo es obligatorio.");
    return false;
  }

  // Email
  let email = document.getElementById("emailRegister").value;
  const regexEmail = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
  if (!regexEmail.test(email)) {
    alert("El correo electrónico no es válido.");
    return false;
  }

  // Contraseña
  let password = document.getElementById("passwordRegister").value;
  const regexPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})$/;
  if (!regexPassword.test(password)) {
    alert("La contraseña debe tener al menos 8 caracteres y al menos una letra minúscula, una letra mayúscula, un número y un símbolo.");
    return false;
  }

  return true;
}

// Evento submit del formulario
document.getElementById("form").addEventListener("submit", validarFormulario);

