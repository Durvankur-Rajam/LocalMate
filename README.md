
<h1 align="center">LocalMate</h1>

<p align="center">
  A lightweight, privacy-focused <strong>desktop chatbot</strong> built using <strong>Java </strong> and integrated with <strong>Ollama</strong> for local LLM interaction.  
  Enjoy a completely offline AI chat experience — powered by your own machine!
</p>

---

## 🚀 Features

- 💬 Chat with a **local LLM** using Ollama  
- 🪶 Built with **Java Swing (JFrame)** for a simple desktop UI  
- ⚡ **Fast and private** — all processing done locally  
- 🧠 Works with multiple Ollama models (like Llama2, Mistral, etc.)  
- 🔌 Easy to configure and extend for developers  

---

## 🛠️ Tech Stack

| Component | Technology |
|------------|-------------|
| Language | Java |
| UI Framework | Java Swing (JFrame) |
| LLM Backend | [Ollama](https://ollama.ai) |
| Build Tool | Maven |

---

## 🎬 Demo

<p align="center">
  <img src="https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExZjYzYmFjZjRjZjJmNTE5NDA2ZTZkYTU2OGQ2NjBiZTY4MmZjM2JjMCZjdD1n/kBrHBDDSyDZwR2l5Zn/giphy.gif" alt="LocalMate Demo" width="400"/>
</p>

---

## 🏗️ Installation & Setup

1. **Clone the repository**
```bash
git clone https://github.com/Durvankur-Rajam/LocalMate.git
cd LocalMate
````

2. **Install Ollama**

* Download Ollama: [https://ollama.ai/download](https://ollama.ai/download)
* Verify installation:

```bash
ollama run llama2 (Or any model of your choice)
```

3. **Build the project**

```bash
mvn clean package
```

4. **Run LocalMate**

```bash
java -jar target/LocalMate.jar
```

---

## 🌱 Future Enhancements

* 🌗 Dark / Light mode UI
* 💾 Chat history persistence
* 🗣️ Voice input / output integration
* 🧠 Model selection UI
* ⚙️ Custom prompt templates

---

## 📄 License

This project is open-source and available under the **MIT License**.

---

<p align="center"> Made with ❤️ by <strong>Durvankur Rajam</strong> </p>



