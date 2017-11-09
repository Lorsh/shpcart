Welcome to the shpcart wiki!
I was just able to get my first commit rolling.
It took a bit more effort than I expected, so I am documenting what I did:

### Install git for windows ###
1) https://git-scm.com/download/win
2) Download the exe file.
3) Install it. You should be able to keep all of the default configurations. 


### Run Git Bash ###
If everything went well, you should be able to find "Git Bash" on your PC. Run it.
Find a place on your computer to create a workspace. A workspace is what I call the folder in which you will have all stuff that we will eventually deliver for our lab. It will mirror our master branch (the files that we commit). 
Now run the following commands:
1. git init (this will initialize a hidden folder inside the workspace which will help git keep track of your commits)
2. git remote add origin https://github.com/Lorsh/shpcart.git (**IMPORTANT: IF YOU ARE COPYING THIS DIRECTLY TO THE TERMINAL, MAKE SURE TO REMOVE THE SPACE BETWEEN origin and https:// and make your own space. For some reason it created a special character in my terminal which caused a bunch of weird issues.**)
3. git pull origin master (here we are going to copy what is currently in our repository so that we are up to date with the latest changes)
4. git add "file_of_some_sort" (this tells git that you are **planning **to commit this file to the repository. Obviously, point to a real file. I encourage you to try and use an empty class if this is your first time).
5. git status (tells you which files you have in your "stage". The stage is where all the files that you are planning to commit. This is more of a sanity check to make sure that you are committing the right files).
6. git commit -m "Some message" (Despite what the name suggests, this is not where you send the files to the repo. This is just to comment on the changes that you made. It is recommended that you **always** comment the changes with some sort of text)
7. git push -u origin master (this is where shit gets real. This is the command that will submit the stage changes to the repo. It will ask for your username and password).





