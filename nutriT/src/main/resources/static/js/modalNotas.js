let pacienteSeleccionado = "";

    function abrirModal(nombre) {
      pacienteSeleccionado = nombre;
      document.getElementById("paciente-actual").innerText = nombre;
      document.getElementById("notaModal").style.display = "flex";
    }

    function cerrarModal() {
      document.getElementById("notaModal").style.display = "none";
    }

    function guardarNota() {
      const nota = document.querySelector("#notaModal textarea").value;
      if (nota.trim() === "") {
        alert("Por favor, escriba una nota.");
        return;
      }

      // Simulación de guardar en BD:
      console.log("Guardando nota para", pacienteSeleccionado + ":", nota);
      alert("Nota guardada para " + pacienteSeleccionado);

      document.querySelector("#notaModal textarea").value = "";
      cerrarModal();
    }

    // Cerrar modal al hacer clic fuera
    window.onclick = function(event) {
      const modal = document.getElementById("notaModal");
      if (event.target === modal) {
        cerrarModal();
      }
    };