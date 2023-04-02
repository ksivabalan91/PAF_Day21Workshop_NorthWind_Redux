echo ----- git init -----
git init
echo ----- git add -----
git add .
echo Commit message
read message
echo ----- git commit-----
git commit -m "$message"
echo Enter repo url
read url
echo ----- git add remote-----
git remote add origin $url
echo ----- git push remote-----
git push origin master