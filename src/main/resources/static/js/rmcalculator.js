
  
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
  
function RM(){
    event.preventDefault();

    // document.getElementById('infos').classList.remove('hidden');
    // const container = document.querySelector('#container');
    // container.style.height += '190vh';

    const weight = parseFloat(document.getElementById("weight").value);
    const reps = parseFloat(document.getElementById("reps").value);
    const RM_1 = ((weight * 0.033 * reps) + weight);
    // const reps_rm = RM_1 / (Peso * (1 / 100) * 0.03);
  
      if (reps === 1) {
         document.getElementById("RM1").innerText = parseInt(weight) + " Kg";
      } else {
         document.getElementById("RM1").innerText = parseInt(RM_1 * (100/100)) + " Kg";
      }
      document.getElementById("RM95").innerText = parseInt(RM_1 * (95/100)) + " Kg";
      document.getElementById("RM90").innerText = parseInt(RM_1 * (90/100)) + " Kg";
      document.getElementById("RM85").innerText = parseInt(RM_1 * (85/100)) + " Kg";
      document.getElementById("RM80").innerText = parseInt(RM_1 * (80/100)) + " Kg";
      document.getElementById("RM75").innerText = parseInt(RM_1 * (75/100)) + " Kg";
      document.getElementById("RM70").innerText = parseInt(RM_1 * (70/100)) + " Kg";
      document.getElementById("RM65").innerText = parseInt(RM_1 * (65/100)) + " Kg";
      document.getElementById("RM60").innerText = parseInt(RM_1 * (60/100)) + " Kg";
      document.getElementById("RM55").innerText = parseInt(RM_1 * (55/100)) + " Kg";
      document.getElementById("RM50").innerText = parseInt(RM_1 * (50/100)) + " Kg";
      document.getElementById("RM45").innerText = parseInt(RM_1 * (45/100)) + " Kg";
      document.getElementById("RM40").innerText = parseInt(RM_1 * (40/100)) + " Kg";
      document.getElementById("RM35").innerText = parseInt(RM_1 * (35/100)) + " Kg";
      document.getElementById("RM30").innerText = parseInt(RM_1 * (30/100)) + " Kg";
      document.getElementById("RM25").innerText = parseInt(RM_1 * (25/100)) + " Kg";
      document.getElementById("RM20").innerText = parseInt(RM_1 * (20/100)) + " Kg";
      document.getElementById("RM15").innerText = parseInt(RM_1 * (15/100)) + " Kg";
      document.getElementById("RM10").innerText = parseInt(RM_1 * (10/100)) + " Kg";

      if (!isNaN(reps && weight)) {
        document.getElementById('infos').classList.remove('hidden');
        container.style.height += '230%';
      } else {
        alert("Rellena todo los datos");
      }

  }
  
  
  