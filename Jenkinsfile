pipeline{
  agent any
    tools {
      maven 'Maven'
  }
  
  stages {
    stage ('Cloning Git') {
      steps {
        git 'https://github.com/Natashanuar/MavenWebAppProject-.git'
     }
    }
    
    stage ('Initialize') {
      steps {
        sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
            ''' 
     }
    }
    
    stage ('Check-The-Secrets') {
      steps {
        sh 'rm trufflehog || true'
        sh 'docker run gesellix/trufflehog --json --regex https://github.com/Natashanuar/MavenWebAppProject-.git > trufflehog'
        sh 'cat trufflehog'
      }
    }
    
    stage ('Software Composition Analysis') {
      steps {
         sh 'rm -r dependency-check* || true' 
         sh 'wget https://github.com/jeremylong/DependencyCheck/releases/download/v6.0.3/dependency-check-6.0.3-release.zip'
         sh 'unzip dependency-check-6.0.3-release.zip'
         sh './dependency-check/bin/dependency-check.sh --scan ./* --enableRetired -f "ALL" '
       }
    }
    
    stage ('Build Execute Jar') {
      steps {
        sh 'mvn clean package'
         }
       }
    
  
    
  }
}
