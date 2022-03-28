def NOMBRE_PROYECTO = "retoTecnicoChoucair";
pipeline {
    agent any

    stages {
        stage('Ejecutar JenkinsFile Prueba Local version de java') {
            steps {
                echo '[EXEC] version java'
                bat 'java -version'
            }
        }
        stage('Prueba Local') {
            steps {
               script {
                  try {
                    bat "chmod +x gradlew"
                    bat "./gradlew clean"
                    bat "./gradlew test -DTiporegresion=\"@FUNCIONALFRONT\" --info"
                    currentBuild.result = 'SUCCESS'
                  } catch(err) {
                    echo "La ejecución de la prueba requiere que algunos escenarios se vuelvan a ejecutar";
                  }

                  try {
                    bat "chmod +x gradlew"
                    bat "./gradlew test -DTiporegresion=\"@PREPARACIONRERUN\" --info"
                    bat "./gradlew test -DTiporegresion=\"@RERUNFUN\" --info"
                    currentBuild.result = 'SUCCESS'
                  } catch(error) {
                    currentBuild.result = 'FAILURE'
                  }
                  echo "El resultado de la prueba segunda ejecución es : '${currentBuild.result}'";
                }
                break
            case "any":
              catchError {
                dir("${workspace}/${NOMBRE_PROYECTO}") {
                  script {
                    try {
                      bat "gradlew clean ${PROXY}";
                      bat "gradlew test -DTiporegresion=\"@FUNCIONALFRONT\" -Dfile.encoding=UTF-8 ${PROXY}";
                      currentBuild.result = 'SUCCESS'
                    } catch(err) {
                      echo "La ejecución de la prueba requiere que algunos escenarios se vuelvan a ejecutar";
                    }

                    try {
                      bat "gradlew test -DTiporegresion=\"@PREPARACIONRERUN\" -Dfile.encoding=UTF-8 ${PROXY}";
                      bat "gradlew test -DTiporegresion=\"@RERUNFUN\" -Dfile.encoding=UTF-8 ${PROXY}";
                      currentBuild.result = 'SUCCESS'
                    } catch(error) {
                      currentBuild.result = 'FAILURE'
                    }
                    echo "El resultado de la prueba segunda ejecución es : '${currentBuild.result}'";
                  }

                }
              }
            }

        }

    }
}