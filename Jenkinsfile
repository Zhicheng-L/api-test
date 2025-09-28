pipeline {
    agent any

    tools {
        maven 'maven3'   // 这里要和 Jenkins 全局工具配置的名字一致
        jdk 'jdk21'      // 同理，使用的 JDK 名称
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh "mvn clean test"
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'  // 收集 JUnit 测试报告
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                sh "mvn allure:report"
            }
        }
    }

    post {
        always {
            allure([
                results: [[path: "target/allure-results"]]
            ])
        }
    }
}
