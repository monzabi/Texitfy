# Textify

**Textify** is a simple, console-based chat messenger built in Java. Designed as a learning tool and a solid foundation for further development, Textify enables real-time private messaging between two users over a network. It’s minimal, reliable, and perfect for those who want to understand the basics of Java networking and socket programming.

---

## Features

- **Private Messaging:** Real-time chat between two users.
- **Console-based:** No GUI — runs entirely in the terminal for simplicity.
- **Lightweight & Minimal:** Focuses on the core logic, making it easy to understand and extend.
- **Educational:** Great starting point for learning Java sockets, networking, and multithreading.

---

## Getting Started

### Prerequisites

- Java 8 or higher
- A command-line terminal

### How It Works

Textify uses Java sockets to establish a direct connection between two users. One user acts as the server (listener), and the other as the client (initiator).

### Running the Server

1. Navigate to the project directory.
2. Compile the server code:
    ```sh
    javac Server.java
    ```
3. Start the server:
    ```sh
    java Server
    ```
   The server will wait for a client connection.

### Running the Client

1. In another terminal (possibly on another machine on the same network), navigate to the project directory.
2. Compile the client code:
    ```sh
    javac Client.java
    ```
3. Start the client, specifying the server IP address if needed:
    ```sh
    java Client
    ```
   When prompted, enter the server's IP address (use `localhost` if on the same machine).

---

## Usage

- Once both the server and client are running and connected, users can type messages and press Enter to send.
- Messages are instantly relayed between the two users over the network.
- To exit, you can typically type a specific keyword (e.g., `/quit`) or close the terminal.

---

## Code Structure

- `Server.java` – Handles incoming client connections and message relaying.
- `Client.java` – Connects to the server and enables message sending and receiving.

---

## Customization

Textify is intentionally simple to allow easy customization and extension. Possible improvements include:

- Adding a graphical user interface (GUI)
- Implementing message encryption
- Supporting multiple clients (group chat)
- Adding message history or logging

## License

This project is open-source and available under the MIT License.

---

## Author

Textify by [monzabi](https://github.com/extSayzz)

---

Feel free to fork, modify, and build upon Textify for your own projects!
