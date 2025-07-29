document.getElementById("registro-form").addEventListener("submit", async function (e) {
    e.preventDefault();

    const data = {
        nombre: document.getElementById("nombre").value,
        apellido: document.getElementById("apellido").value,
        email: document.getElementById("email").value,
        contrasena: document.getElementById("contrasena").value,
    };

    try {
        const response = await fetch("http://localhost:8080/auth/registro", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        const mensajeDiv = document.getElementById("mensaje");

        if (response.ok) {
            const result = await response.json();
            mensajeDiv.style.color = "green";
            mensajeDiv.textContent = `✅ Registro exitoso. Bienvenido ${result.nombre}`;
            setTimeout(() => {
                window.location.href = "iniciarSesion.html";
            }, 2000);
        } else {
            const errorText = await response.text();
            mensajeDiv.style.color = "red";
            mensajeDiv.textContent = `❌ Error: ${errorText}`;
        }
    } catch (error) {
        const mensajeDiv = document.getElementById("mensaje");
        mensajeDiv.style.color = "red";
        mensajeDiv.textContent = "❌ Error de conexión con el servidor.";
        console.error("Error:", error);
    }
});