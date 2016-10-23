printf "!!!!READ THIS BEFORE CONTINUING!!!!\n
Make sure you are in the root project directory before you continue.\n
By default the root project directory should be: 
collab-app-master\n\n"

read -p "Would you like to continue? (Y/N)" -n 1 -r
echo    
if [[ $REPLY =~ ^[Yy]$ ]]
  then
    git init
    git add .
    git commit -m "Initial Commit" 
    git remote add origin https://github.com/SE2019/collab-app  
#    git remote 
#    git branch
    printf "Done"
    echo
fi
