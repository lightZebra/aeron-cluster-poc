echo "start node3" >> node0.txt
echo "start node3" >> node1.txt
echo "start node3" >> node2.txt
echo "start node3" >> node3.txt

bash d-node-3.sh >> node3.txt

echo "stop node3" >> node0.txt
echo "stop node3" >> node1.txt
echo "stop node3" >> node2.txt
echo "stop node3" >> node3.txt

