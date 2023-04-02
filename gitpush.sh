echo ----- git add -----
git add .
echo Commit message
read message
echo ----- git commit-----
git commit -m "$message"
echo ----- git push-----
git push origin master