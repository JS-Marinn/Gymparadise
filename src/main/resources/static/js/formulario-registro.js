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
    var formulario = document.querySelector("form");
    var formBox = document.querySelector(".formulario-container");
    var pesoInput = document.getElementById("peso");
    var fechaInput = document.getElementById("fecha");

    formulario.addEventListener("submit", function(event) {
        var error = false; // Variable para rastrear si se ha producido un error

        // Eliminar contorno rojo
        quitarContornoRojo();

        if (!validarPeso(pesoInput.value)) {
            pesoInput.classList.add("input-error");
            error = true;
        }

        if (!validarFecha(fechaInput.value)) {
            fechaInput.classList.add("input-error");
            error = true;
        }

        // Ajustar la altura del formulario-container si se ha producido un error
        if (error) {
            formBox.style.height = "auto"; // Restaurar la altura predeterminada
            event.preventDefault();
        }
    });

    // Funciones de validación
    function validarPeso(peso) {
        // Aquí puedes agregar una expresión regular u otras validaciones específicas para el campo "Peso"
        // Por ejemplo, para validar que sea un número positivo, podrías usar:
        var regex = /^\d+(\.\d+)?$/;
        return regex.test(peso);
    }

    function validarFecha(fecha) {
        // Aquí puedes agregar validaciones específicas para el campo "Fecha"
        // Por ejemplo, puedes verificar que la fecha esté en un formato específico o que sea una fecha válida en el calendario.
        // Dependerá de tus requisitos específicos.
        // En este ejemplo, asumimos que el navegador validará la entrada como una fecha válida.
        return true;
    }

    // Resto del código para quitar el contorno rojo (sin cambios).
    function quitarContornoRojo() {
        pesoInput.classList.remove("input-error");
        fechaInput.classList.remove("input-error");
    }
});

