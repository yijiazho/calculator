# Project
## Description
A basic calculator supporting different kinds of operations. Assume the input is double percision numbers in IEEE 754. Assume the chain operation follows the sequential order. The result might overflow to infinity.

## Structure
```
calculator
├─.mvn
│  └─wrapper
├─.vscode
├─pom.xml
├─.gitignore
├─README.md
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─calculator
│  │  │          ├─backend
│  │  │          ├─configuration
│  │  │          ├─controller
│  │  │          └─operations
│  │  └─resources
│  └─test
│      └─java
│          └─com
│              └─calculator
│                  ├─backend
│                  └─controller
```

## Commands

### Run the project
Use `mvn clean install`

### Run the tests
Use `mvn test`