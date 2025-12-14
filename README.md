# Spring Batch Job - POC

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![Java](https://img.shields.io/badge/Java-17%2B-orange)](https://www.oracle.com/java/)
[![Spring Batch](https://img.shields.io/badge/Spring%20Batch-5.x-brightgreen)](https://spring.io/projects/spring-batch)

A practical proof-of-concept (POC) project demonstrating Spring Batch fundamentals for batch processing operations. This project serves as a learning resource to understand how Spring Batch handles large-scale data processing tasks efficiently.

## 📋 Table of Contents

- [About Spring Batch](#about-spring-batch)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [How It Works](#how-it-works)
- [Running the Application](#running-the-application)
- [Key Concepts](#key-concepts)
- [Learning Resources](#learning-resources)
- [License](#license)

## 🎯 About Spring Batch

Spring Batch is a lightweight, comprehensive framework designed to enable the development of robust batch applications. It provides reusable functions essential for processing large volumes of records, including:

- **Transaction management**
- **Chunk-based processing**
- **Job restart, skip, and retry capabilities**
- **Logging and tracing**
- **Resource management**

This POC demonstrates these core concepts in a simplified, easy-to-understand implementation.

## ✨ Features

- ✅ Simple batch job configuration
- ✅ Step-by-step processing demonstration
- ✅ ItemReader, ItemProcessor, and ItemWriter implementation
- ✅ In-memory H2 database for job metadata
- ✅ Gradle build configuration
- ✅ Clean, well-structured code for learning

## 📦 Prerequisites

Before running this project, ensure you have:

- **Java 17** or higher installed
- **Gradle** (or use the included Gradle wrapper)
- Basic understanding of Spring Framework
- IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)

## 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/Himanshusinghtomar/spring_batch_job.git
cd spring_batch_job
```

### Build the Project

Using Gradle wrapper (recommended):

```bash
./gradlew build
```

Or if you have Gradle installed:

```bash
gradle build
```

## 📁 Project Structure

```
spring_batch_job/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/batch/
│   │   │       ├── config/          # Batch configuration classes
│   │   │       ├── reader/          # ItemReader implementations
│   │   │       ├── processor/       # ItemProcessor implementations
│   │   │       └── writer/          # ItemWriter implementations
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
└── README.md
```

## ⚙️ How It Works

### Spring Batch Architecture

```
┌─────────────┐
│ JobLauncher │ ──┐
└─────────────┘   │
                  ▼
            ┌─────────┐
            │   Job   │
            └─────────┘
                  │
        ┌─────────┼─────────┐
        ▼         ▼         ▼
    ┌──────┐  ┌──────┐  ┌──────┐
    │Step 1│  │Step 2│  │Step 3│
    └──────┘  └──────┘  └──────┘
        │         │         │
        └─────────┴─────────┘
                  │
                  ▼
          ┌──────────────┐
          │ JobRepository│
          └──────────────┘
```

### Processing Flow

1. **Read**: ItemReader reads data from a source (CSV, database, etc.)
2. **Process**: ItemProcessor transforms/validates the data
3. **Write**: ItemWriter outputs processed data to a destination
4. **Commit**: Changes are committed in chunks for better performance

## 🏃 Running the Application

### Using Gradle

```bash
./gradlew bootRun
```

### Using Java

```bash
./gradlew build
java -jar build/libs/spring_batch_job-0.0.1-SNAPSHOT.jar
```

### Expected Output

The application will:
1. Initialize the Spring Batch infrastructure
2. Create necessary database tables (H2 in-memory)
3. Execute the configured batch job
4. Display processing statistics and results
5. Store job execution metadata

## 📚 Key Concepts

### Job
A Job represents the entire batch process. It encapsulates multiple steps that execute sequentially or conditionally.

### Step
A Step represents a phase in the batch job. Each step typically consists of:
- **ItemReader**: Reads input data
- **ItemProcessor**: Processes/transforms data
- **ItemWriter**: Writes output data

### Chunk Processing
Spring Batch processes data in configurable chunks rather than one item at a time, improving performance and memory usage.

```java
// Example chunk size of 10
Step step = stepBuilderFactory.get("step1")
    .<InputType, OutputType>chunk(10)
    .reader(reader())
    .processor(processor())
    .writer(writer())
    .build();
```

### Job Repository
Stores metadata about job executions, including:
- Job instances
- Job parameters
- Execution status
- Step execution details

## 🎓 Learning Resources

### Official Documentation
- [Spring Batch Reference Documentation](https://docs.spring.io/spring-batch/docs/current/reference/html/)
- [Spring Batch GitHub Repository](https://github.com/spring-projects/spring-batch)

### Tutorials
- [Baeldung Spring Batch Tutorial](https://www.baeldung.com/introduction-to-spring-batch)
- [Spring.io Getting Started Guide](https://spring.io/guides/gs/batch-processing/)

### Books
- "Spring Batch in Action" by Arnaud Cogoluegnes
- "The Definitive Guide to Spring Batch" by Michael T. Minella

## 🛠️ Common Use Cases

Spring Batch is ideal for:

- 📊 **Data Migration**: Moving data between systems
- 📁 **File Processing**: Reading/writing CSV, XML, JSON files
- 🔄 **ETL Operations**: Extract, Transform, Load workflows
- 📧 **Bulk Notifications**: Sending emails or notifications in batches
- 🧮 **Report Generation**: Creating periodic reports
- 🗃️ **Data Archival**: Moving old data to archives
- 🔍 **Data Validation**: Validating large datasets

## 🤝 Contributing

This is a learning POC project. Feel free to fork and experiment with:
- Different data sources (CSV, XML, database)
- Custom processors and transformers
- Parallel processing configurations
- Job scheduling with Spring Scheduler or Quartz

## 📝 Notes

- This project uses an **in-memory H2 database** for simplicity
- Job metadata is not persisted between application restarts
- For production use, configure a persistent database (MySQL, PostgreSQL, etc.)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Himanshu Singh Tomar**

- GitHub: [@Himanshusinghtomar](https://github.com/Himanshusinghtomar)

## 🙏 Acknowledgments

- Spring Batch Team for the amazing framework
- Spring Boot Team for seamless integration
- The open-source community for excellent documentation and examples

---

**Happy Learning! 🚀**

If you find this POC helpful, please consider giving it a ⭐ on GitHub!