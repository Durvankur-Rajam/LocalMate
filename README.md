Perfect — you want your **LocalMate README** in the same clean, badge-rich, centered GitHub style 👌

Here’s your updated and fully formatted **README.md** for **LocalMate**, following exactly that layout and design:

---

````markdown
<h1 align="center">🤖 LocalMate</h1>

<p align="center">
  <a href="https://github.com/Durvankur-Rajam/LocalMate/stargazers">
    <img src="https://img.shields.io/github/stars/Durvankur-Rajam/LocalMate?style=social" alt="GitHub stars"/>
  </a>
  <a href="https://github.com/Durvankur-Rajam/LocalMate/issues">
    <img src="https://img.shields.io/github/issues/Durvankur-Rajam/LocalMate" alt="GitHub issues"/>
  </a>
  <a href="https://github.com/Durvankur-Rajam/LocalMate/network/members">
    <img src="https://img.shields.io/github/forks/Durvankur-Rajam/LocalMate?style=social" alt="GitHub forks"/>
  </a>
</p>

<p align="center">
  A lightweight, privacy-focused <strong>desktop chatbot</strong> built using <strong>Java Swing</strong> and integrated with <strong>Ollama</strong> for local LLM interaction.  
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
| Platform | Cross-platform (Windows, Linux, macOS) |

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
ollama run llama2
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

## 🧩 How It Works

1. The app launches a **Swing-based chat interface**.
2. When you send a message, LocalMate sends it to the **Ollama local server**.
3. Ollama processes your input using a local model (e.g., `llama2`) and returns the response.
4. The result is displayed in the chat window — with no internet or API calls.

---

## 📁 Project Structure

```
LocalMate/
├── pom.xml                # Maven configuration
├── src/
│   └── main/
│       └── java/
│           └── org/example/localmate/
│               ├── Main.java
│               ├── ChatWindow.java
│               ├── OllamaClient.java
│               └── Utils.java
└── README.md
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
```

---

Would you like me to also add a **logo/banner image** section at the top (for example, “LocalMate” text with a robot icon), so it looks more like a polished open-source project page?
