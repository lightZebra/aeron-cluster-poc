echo "start client" >> node0.txt
echo "start client" >> node1.txt
echo "start client" >> node2.txt
echo "start client" >> node3.txt

bash client-interactive.sh >> node-client.txt

echo "stop client" >> node0.txt
echo "stop client" >> node1.txt
echo "stop client" >> node2.txt
echo "stop client" >> node3.txt

