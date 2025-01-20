# Communicating across a network
## What is networking?
Networking is the capability to make a connection from our application to a system over a network. Systems such as a server maybe or some API or some other application performing IO operations. 

## Protocols
- **TCP (Transmission Control Protocol)**  - 
1. Imagine a phone call:
	- You first check if the other person is there (TCP handshake)
	- We speak one sentence at a time and wait for a confirmation that the other person heard it 
	- If the other person didn't hear correctly we repeat what we said (TCP will resend lost or corrupt data)
	- By the end both of the communicating parties will know everything that was communicated 
	
TCP guarantees a reliable data flow between two devices. TCP provides a point-to-point connection-based channel for applications.  

- **UDP (Use Datagram Protocol)**  - 
1. Imagine sending a postcard
	- We write a quick message and we drop it in the mail, you dont check if it arrived or someone read it (UDP doesnt require confirmation)
	- We can send multiple postcards but there is no guarantee that they will arrive in the order we sent them
	- Some postcards might get lost in the mail entirely, and we wouldnt know what went missing. (UDP doesn't handle data loss)
	
| Feature | TCP | UDP |
|--|--| --| 
| Connection | Required (TCP handshake)  | No confirmation required |
| Delivery| Guaranteed delivery |Unreliable but faster |
| Order | Data is rearranged in the right order before giving it to the application | Order is not preserved|
| Use Cases | Web browsing, email, file transfers (anything where accuracy is important) |Live streaming, video conferencing, online gaming (use when speed is more important than accuracy) |

### Why choose one over the other?
* TCP is used when you need to be sure your data arrive in full and in order
* UDP is used when speed is crucial and its okay to lose some data (data packets)


## What is an IP address?
* IP (internet protocol) address - is a unique number assigned to each device that is connected to a network.
*  IPv4 (32 bit address) - 192.168.1.1  (4 numbers separate by dots).  Shorter and older.
* IPv6 (64 bit address) - 2oo1:0db8:85a3:000:0000:000:000 (8 groups of hexadecimal numbers separated by colons). Newer and much longer.

## Why do we need IP addresses?
Every device from our phones to huge servers, each device needs to be uniquely identified on the Internet. E.g when you send an email or load a web page, the data needs to know where its going.

## Domain Names and DNS
* **Domain Name** - a friendly name like example.com, its easier for humans to remember than numbers
* **DNS (Domain Name System)** - it works like a big phone book for the internet. DNS translates the domain name into an IP address. Domain name for an IP address **94.32.124.24** for **example.com**

## Public vs Private IP Addresses
* Public IP - the address everyone can see when we go online. It is given to us by our ISP
	* Example: 203.0.114.5
	* This is how websites and services on the internet can send us information or data
Private IP - used inside our local/home/office network only
	* Example: 192.168.1.1
	* These addresses cant be accessed directly from the internet 
## How data travels using IP Addresses?
1. We type www.example.com into our browser
2. Our PC asks the DNS for the IP address of www.example.com
3. DNS replies with something like 93.234.32.42
4. Our PC sends a request to  93.234.32.42, asking for the webpage
5. The server host send data (webpage files) back to our PC's IP address
6. We see the website in our browser

## InetAddress Class
* This is a class that represents an IP address
* We can use this to work with IPv4 and IPv6 addresses 
* Common things we can do with this class:
	* Find the IP address of a domain
	* Get local host information 

## Ports
A simple analogy
* House Address - our computer address (IP)
* Rooms - ports. 
Inside the house there are many rooms (ports), each used for a different purpose. 

### Key Points about Ports

 1. **Port Number range** - they range from 0 - 65535
	 * **Popular ports** - these HTTP - port 80, HTTPS - port 443, FTP - port 21, SMTP - port 25
	 
2. **We can have 1 IP many Ports** - a single machine (IP Address) it can run multiple services on different ports:
	* Web server or port 80
	* Secure web server on port 443
	* Email server on port 25 
	* 
3. **Listening Ports** - When a service like a web server is running it listens on a specific port for incoming data 
4. **Security and Firewalls** - firewalls can block your ports and allow certain traffic or data on certain ports.
5. **Client Ports** - when we visit a website for example , our browser uses a random, high-numbered port on our side to talk to the server's listening port, it returns a response back.

## What is a socket?
Sockets in java are like two "telephone lines" of network programming. They allow two apps these are often called client and server to communicate over the internet or any network. 

### Client vs Server
1. **ServerSocket** (Server Side)
	* A server waits (listens) on a port for incoming connections
	* When a client connects, the server accepts the connection, it creates a socket to talk to the specific client
2. **Socket** (Client Side)
	* A client creates a socket to connect to the server (ServerSocket) its gonna use an IP addres and port number
	* Once connection, the client and server can send and received data back and fort
