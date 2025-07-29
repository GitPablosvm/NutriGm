document.getElementById("login-form").addEventListener("submit", async function (e) {
    e.preventDefault();

    const data = {
        email: document.getElementById("email").value,
        contrasena: document.getElementById("login-password").value,
    };

    try {
        const response = await fetch("http://localhost:8080/auth/login", {
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
            mensajeDiv.textContent = `✅ Inicio de sesión exitoso. Bienvenido `; //${result.nombre}
            
            // Guardar datos en localStorage (opcional)
            localStorage.setItem("usuario", JSON.stringify(result));

            setTimeout(() => {
                // Redirigir a la página principal o dashboard
                window.location.href = "paciente.html";
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
