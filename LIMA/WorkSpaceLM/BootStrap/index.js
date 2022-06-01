const btnToast = document.getElementById("btnToast")
const toast = document.getElementById("toast")
    btnToast.addEventListener('click', () => {
        const tToast = new bootstrap.Toast(toast)
        tToast.show()
    }) 
