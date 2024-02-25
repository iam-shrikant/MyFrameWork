pipeline {
    agent any

    stages {
        stage('clean') {
            steps {
                echo 'Running clean stage'
                echo 'Stoped clean stage'
            }
        }
        stage('validate') {
            steps {
                echo 'Running validate stage'
                echo 'Stoped validate stage'
            }
        }
        stage('Compile') {
            steps {
                echo 'Running Compile stage'
                echo 'Stoped Compile stage'
            }
        }
    }

	post{
		success{
			echo 'script is successfully run'
			build 'FirstJobToRun'
		}
	}

}
