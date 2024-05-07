# start local kubernetes if mimikube is used
minikube start

# create/apply k8s cluster configuration
kubectl apply -f deploy.yml

# display available deployments
kubectl get deployments

# watch mode
kubectl get deployments --watch

# describe deployment
kubectl describe deploy DEPLOYMENT_NAME

# delete deployment
kubectl delete deploy DEPLOYMENT_NAME

# display running pods
kubectl get pods

# watch mode
kubectl get pods --watch

# display selected pod's output
kubectl logs POD_NAME

# open pod's console (if available)
kubectl exec -it POD_NAME -- bash