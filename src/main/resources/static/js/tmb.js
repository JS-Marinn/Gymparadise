function bmi() {
  event.preventDefault();
  const weight = parseFloat(document.getElementById("weight").value);
  const height = parseFloat(document.getElementById("height").value);
  const age = parseFloat(document.getElementById("age").value);
  const sex = document.getElementById("sex").value;
  const physicalActivity = document.getElementById("physicalActivity").value;

  var bmi = (weight / ((height / 100) ** 2)).toFixed(2);

  
  var currentLanguage = 'en'; // Puedes establecer esto dinámicamente según la configuración de tu aplicación
  

  var messages = {
    'es': {
        'bmi.infinity': 'Infinito',
        'bmi.underweight': 'Cuidado! Usted está bajo de peso!',
        'bmi.ideal': 'Usted está en su peso ideal!',
        'bmi.overweight': 'Cuidado! Usted tiene sobrepeso!',
        'bmi.moderateObesity': 'Cuidado! Usted tiene obesidad moderada!',
        'bmi.severeObesity': 'Cuidado! Usted tiene obesidad severa',
        'bmi.inappropriateValues': 'Ingrese valores apropiados'
    },
    'en': {
        'bmi.infinity': 'Infinity',
        'bmi.underweight': 'Careful! You are underweight!',
        'bmi.ideal': 'You are at your ideal weight!',
        'bmi.overweight': 'Careful! You are overweight!',
        'bmi.moderateObesity': 'Careful! You have moderate obesity!',
        'bmi.severeObesity': 'Careful! You have severe obesity',
        'bmi.inappropriateValues': 'Enter appropriate values'
    }
};

  // Tu código JavaScript original
  if (!isNaN(bmi)) {
      if (bmi > 999) {
          value.textContent = messages[currentLanguage]['bmi.infinity'];
      } else {
          value.textContent = bmi.replace('.', ',');
      }
  
      if (bmi < 18.5) {
          description.textContent = messages[currentLanguage]['bmi.underweight'];
          value.classList.add('attention');
      } else if (bmi >= 18.5 && bmi <= 25) {
          description.textContent = messages[currentLanguage]['bmi.ideal'];
          value.classList.add('normal');
      } else if (bmi > 25 && bmi <= 30) {
          description.textContent = messages[currentLanguage]['bmi.overweight'];
          value.classList.add('warning-1');
      } else if (bmi > 30 && bmi <= 35) {
          description.textContent = messages[currentLanguage]['bmi.moderateObesity'];
          value.classList.add('warning-2');
      } else if (bmi > 35 && bmi <= 40) {
          description.textContent = messages[currentLanguage]['bmi.severeObesity'];
          value.classList.add('attention');
      } else {
          description.textContent = messages[currentLanguage]['bmi.inappropriateValues'];
          value.classList.add('attention');
      }
  }
  

  // Gasto calorico normal
  var GCN;
  // Factor actividad física o calorías de mantenimiento
  var caloriesMaintenance;


  switch (sex) {
      case "1":
          GCN = (10 * weight) + (6.25 * height) - (5 * age) + 5;
          break;
      case "2":
          GCN = (10 * weight) + (6.25 * height) - (5 * age) - 161;
          break;
  }
  
  switch (physicalActivity) {
      case "1":
          caloriesMaintenance = GCN * 1.2;
          break;
      case "2":
          caloriesMaintenance = GCN * 1.375;
          break;
      case "3":
          caloriesMaintenance = GCN * 1.55;
          break;
      case "4":
          caloriesMaintenance = GCN * 1.725;
          break;
      case "5":
          caloriesMaintenance = GCN * 1.9;
          break;    
  }

  // Calorías
  caloriesCut = caloriesMaintenance - caloriesMaintenance * 0.2;
  caloriesBulk = caloriesMaintenance + caloriesMaintenance * 0.2;

  // Proteina
  proteinMaintenance = weight * 1.8;
  proteinCut = weight * 2.5;
  proteinBulk = weight * 2.2;

  // Grasas
  fatMaintenance = weight * 0.75;
  fatCut = weight * 0.5;
  fatBulk = weight * 1.5;

  // Carbohidratos
  carbsMaintenance = ((caloriesMaintenance - (proteinMaintenance*4 + fatMaintenance*9))/4);
  carbsCut = ((caloriesCut - (proteinCut*4 + fatMaintenance*9))/4);
  carbsBulk = ((caloriesBulk - (proteinBulk*4 + fatBulk*9))/4);

  document.getElementById("proteinCut").innerText = parseInt(proteinCut) + " g";
  document.getElementById("fatCut").innerText = parseInt(fatCut) + " g";
  document.getElementById("carbsCut").innerText = parseInt(carbsCut) + " g";
  document.getElementById("caloriesCut").innerText = parseInt(caloriesCut) + " Kcal";
  document.getElementById("proteinMaintenance").innerText = parseInt(proteinMaintenance) + " g";
  document.getElementById("fatMaintenance").innerText = parseInt(fatMaintenance) + " g";
  document.getElementById("carbsMaintenance").innerText = parseInt(carbsMaintenance) + " g";
  document.getElementById("caloriesMaintenance").innerText = parseInt(caloriesMaintenance) + " Kcal"
  document.getElementById("proteinBulk").innerText = parseInt(proteinBulk) + " g";
  document.getElementById("fatBulk").innerText = parseInt(fatBulk) + " g";
  document.getElementById("carbsBulk").innerText = parseInt(carbsBulk) + " g";
  document.getElementById("caloriesBulk").innerText = parseInt(caloriesBulk) + " Kcal";

  if (!isNaN(carbsCut)) {
    document.getElementById('infos').classList.remove('hidden');
    container.style.height += '170%';
  } else {
    alert("Rellena todo los datos");
  }

}


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



   


