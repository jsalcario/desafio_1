// Pipeline declarativo
pipeline {
    agent any
// Parametros de entrada
    parameters {
        string(
            name: 'Nombre',
            defaultValue: '',
            description: 'Ingrese el nombre del usuario'
        )
        string(
            name: 'Apellido',
            defaultValue: '',
            description: 'Ingrese el apellido del usuario'
        )
        choice(
            name: 'Departamento',
            choices: ['Finanzas', 'Contabilidad', 'Tecnologia'],
            description: 'Seleccione el departamento'
        )
    }
    stages {
        //stage para crear los grupos
        stage('Crear grupos') {
            steps {
                script {
                    def grupos = ['Finanzas', 'Contabilidad', 'Tecnologia']
                    for (grupo in grupos) {
                        sh "sudo groupadd ${grupo}"
                    }
                }
            }
        }
        //stage para crear el usuario
        stage('Crear usuario') {
            steps {
                script {
                    //obtener los parametros
                    def nombre = params.Nombre
                    def apellido = params.Apellido
                    def departamento = params.Departamento
                    
                    //generar el login
                    def login = "${nombre}.${apellido}".toLowerCase()

                    //generar contraseña temporal
                    def password = UUID.randomUUID().toString().take(8)

                    // Crear el usuario
                    sh """
                        sudo useradd -m -s /bin/bash -c "${nombre} ${apellido}" ${login}
                        sudo usermod -aG ${departamento} ${login}
                    """

                    // Mostrar la contraseña temporal
                    echo "Usuario creado: ${login}"
                    echo "Pertenece al departamento: ${departamento}"
                    echo "Contraseña temporal: ${password}"
                    echo "Por favor cambiar la contraseña en el primer inicio de sesion"
                }
            }
        }
    }
}
