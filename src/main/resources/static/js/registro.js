document.addEventListener("DOMContentLoaded", function() {
    var formulario = document.querySelector("form");
    var formBox = document.querySelector(".form-box");
    var nombreInput = document.getElementById("nombre");
    var apellidoInput = document.getElementById("apellido");
    var emailInput = document.getElementById("email");
    var passwordInput = document.getElementById("password");

    formulario.addEventListener("submit", function(event) {
        var error = false; // Variable para rastrear si se ha producido un error

        // Eliminar mensajes de error existentes y el contorno rojo
        eliminarMensajesError();
        quitarContornoRojo();

        if (!validarNombre(nombreInput.value)) {
            nombreInput.classList.add("input-error");
            error = true;
        }

        if (!validarNombre(apellidoInput.value)) {
            apellidoInput.classList.add("input-error");
            error = true;
        }

        if (!validarEmail(emailInput.value)) {
            emailInput.classList.add("input-error");
            error = true;
        }

        if (!validarPassword(passwordInput.value)) {
            passwordInput.classList.add("input-error");
            error = true;
        }

        // Ajustar la altura del form-box si se ha producido un error
        if (error) {
            formBox.style.height = "680px"; // Hacer que la altura sea automática
            event.preventDefault();
        }
    });

    // Resto del código de validación y funciones
    function validarNombre(nombre) {
        var regex = /^[a-zA-ZáéíóúÁÉÍÓÚüÜ\s]*$/; // Acepta letras, tildes, espacios y la letra ü
        return regex.test(nombre);
    }

    function validarEmail(email) {
        var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return regex.test(email);
    }

    function validarPassword(password) {
        // La contraseña debe tener al menos 8 caracteres, incluyendo al menos un número y una mayúscula
        var regex = /^(?=.*\d)(?=.*[A-Z]).{8,}$/;
        return regex.test(password);
    }

    // Función para eliminar los mensajes de error generados por JavaScript
function eliminarMensajesError() {
    var errorMessages = document.querySelectorAll(".input-error");
    errorMessages.forEach(function(errorMessage) {
        errorMessage.classList.remove("input-error");
    });
}

    // Función para quitar el contorno rojo
    function quitarContornoRojo() {
        nombreInput.classList.remove("input-error");
        apellidoInput.classList.remove("input-error");
        emailInput.classList.remove("input-error");
        passwordInput.classList.remove("input-error");
    }
});

document.addEventListener("DOMContentLoaded", function() {
  const languageSelect = document.getElementById("language-select");

  languageSelect.addEventListener("change", function () {
    const selectedLanguage = languageSelect.value;
    window.location.href = selectedLanguage;
  });
});
