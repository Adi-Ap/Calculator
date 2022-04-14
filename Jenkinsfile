pipeline {
  environment {
    imagename = "adi007ap/calculator"
    registryCredential = 'adi007ap-dockerhub'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git([url: 'https://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@github.com/Adi-Ap/Calculator.git', branch: 'master', credentialsId: 'adi-github'])

      }
    }
    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build imagename
        }
      }
    }
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
             dockerImage.push('latest')
          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps{
         sh "docker rmi $imagename:latest"
      }
    }

    stage("Invoke ansible playbook") {
      steps{
      ansiblePlaybook(
      	credentialsId: "contnainer_access_key",
        inventory: "inventory",
        installation: "ansible",
        limit: "",
        playbook: "playbook.yaml",
        extras: ""
      )
    }
    }

  }
}
