<img src="data/thumbnail-0.jpg" alt="Algorithms Banner" width="1280"/>

# Data Structures & Algorithms 🚀

> Mastering algorithms one step at a time with Java ☕, Python 🐍, and C++ ⚡ using Visual Studio Code 💻.

## 📚 Overview

This repository is a comprehensive collection of Data Structures and Algorithms implementations, designed for learning and practice. It supports multiple programming languages and includes detailed examples and test cases.

## 🗂️ Project Structure

```
data-structures-algorithms/
├── src/               # Source code organized by topics
├── lib/               # External dependencies (including algs4.jar)
├── build/            # Compiled output files
└── data/             # Input data files for examples
```

## 💻 Development Setup

### Prerequisites
- Java JDK 11 or higher
- Python 3.x
- C++ Compiler (g++)
- Visual Studio Code
- Required VS Code Extensions:
  - Java Extension Pack
  - Python
  - C/C++

## 🚀 Running Programs

### 1. Java Programs
```powershell
# Compile
javac -cp ".;lib/algs4.jar" src/<path-to-file>/<filename>.java -d build

# Run with interactive input
java -cp ".;build;lib/algs4.jar" <ClassName>

# Run with file input
Get-Content .\data\<inputfile>.txt | java -cp ".;build;lib/algs4.jar" <ClassName>
```

### 2. Python Programs
```powershell
# Run with interactive input
python src/<path-to-file>/<filename>.py

# Run with file input
Get-Content .\data\<inputfile>.txt | python src/<path-to-file>/<filename>.py
```

### 3. C++ Programs
```powershell
# Compile
g++ -o build/<ProgramName> src/<path-to-file>/<filename>.cpp

# Run with interactive input
build\<ProgramName>.exe

# Run with file input
Get-Content .\data\<inputfile>.txt | .\build\<ProgramName>.exe
```

## 📦 Key Components

### Data Structures
- Arrays & Lists 📊
- Trees & Graphs 🌳
- Hash Tables 🗃️
- Stacks & Queues 📚

### Algorithms
- Sorting Algorithms 📈
- Searching Techniques 🔍
- Graph Algorithms 🕸️
- Dynamic Programming ⚡

## 🧪 Testing

Each implementation includes:
- Unit tests
- Sample input files
- Performance benchmarks

## 📚 Learning Path

1. **Fundamentals**
   - Basic data structures
   - Time complexity analysis
   - Space complexity analysis

2. **Advanced Topics**
   - Complex algorithms
   - Optimization techniques
   - Problem-solving strategies

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Open a Pull Request

## 📌 Dependencies

The `JAVA PROJECTS` view in VS Code allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

---
Happy Coding! 💫
