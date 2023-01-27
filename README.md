# Pre-APCS-Final-Project - Matthew Chen
# What it does
This project takes in connections between friends and creates a undirected graph. Every query takes in a friend name and recommends people that haven't been recommended already based off of the number of intermediate friends. In graph terms, on the i-th query of a node, it will print all nodes distance i from the given node.
# How to use
Input 2 numbers, n and m, separated by a space, the number of connections and number of queries.  
The next n lines will consist of 2 names separated by a space indicating those people are friends.  
The next m lines will consist of a name used previously and will recommend more friends.  
For example:  
6 4  
Bessie Buttercup  
Bessie Belinda  
Belinda Beatrice  
Belinda Bella  
Beatrice Blue  
Bella Blue  
Bessie  
Bessie  
Bessie  
Belinda  
