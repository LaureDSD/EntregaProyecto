document.getElementById("loginForm").addEventListener("submit", function(event) {
        event.preventDefault(); // Previene el envío por defecto del formulario

        const correo = document.getElementById("correo").value;
        const contraseña = document.getElementById("contraseña").value;

        fetch('/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: new URLSearchParams({
                correo: correo,
                contraseña: contraseña
            })
        })
        .then(response => response.json())
        .then(data => {
            if (data.token) {
                // Almacenar el token en el localStorage
                localStorage.setItem('token', data.token);

                // Imprimir el token almacenado en consola
                console.log("Token almacenado:", localStorage.getItem('token'));

                // Redirigir al dashboard
                window.location.href = 'admin/dashboard';
            } else {
                alert("Error en el login: " + (data.error || "Error desconocido"));
            }
        })
        .catch(error => {
            alert("Error al intentar iniciar sesión: " + error.message);
        });
    });