registry_user=$1
registry_pass=$2
image_name=weather
node_user=ubuntu
node_ip=110.42.143.198

ssh $node_user@$node_ip "sudo docker login --username=$registry_user --password=$registry_pass"
ssh $node_user@$node_ip "sudo docker pull $image_name && docker rm -f $image_name || true "
ssh $node_user@$node_ip "sudo docker run -itd --name=$image_name --restart=always  --net=host  -e TZ="Asia/Shanghai" $image_name"