git checkout -b feature-a ---> -b will create a new branch
git add .
git commit -m 'added messages'
git push --set-upstream origin feature-a --------> create a new branch in BIT hub

git checkout master
git merge feature-a
git push



-------
git --version


chnages

git status

debashish.barik@M5-L-HZ2CFW2 MINGW64 /c/UBS/CW/demo/cw-demo (feature-a)
$ git status
On branch feature-a
Your branch is up to date with 'origin/feature-a'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   spring-cloud-stream-kafka/src/main/java/com/ubs/cw/cloudstream/kafka/SpringCloudStreamKafkaApplication.java

no changes added to commit (use "git add" and/or "git commit -a")

debashish.barik@M5-L-HZ2CFW2 MINGW64 /c/UBS/CW/demo/cw-demo (feature-a)
$ git add spring-cloud-stream-kafka/src/main/java/com/ubs/cw/cloudstream/kafka/SpringCloudStreamKafkaApplication.java

debashish.barik@M5-L-HZ2CFW2 MINGW64 /c/UBS/CW/demo/cw-demo (feature-a)
$ git status
On branch feature-a
Your branch is up to date with 'origin/feature-a'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   spring-cloud-stream-kafka/src/main/java/com/ubs/cw/cloudstream/kafka/SpringCloudStreamKafkaApplication.java


debashish.barik@M5-L-HZ2CFW2 MINGW64 /c/UBS/CW/demo/cw-demo (feature-a)
$ git commit -m 'Logging enabled'
[feature-a d957c95] Logging enabled
 Committer: Barik <debashish.barik@accenture.com>
Your name and email address were configured automatically based
on your username and hostname. Please check that they are accurate.
You can suppress this message by setting them explicitly:

    git config --global user.name "Your Name"
    git config --global user.email you@example.com

After doing this, you may fix the identity used for this commit with:

    git commit --amend --reset-author

 1 file changed, 4 insertions(+), 1 deletion(-)

debashish.barik@M5-L-HZ2CFW2 MINGW64 /c/UBS/CW/demo/cw-demo (feature-a)
$ git status
On branch feature-a
Your branch is ahead of 'origin/feature-a' by 1 commit.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean

debashish.barik@M5-L-HZ2CFW2 MINGW64 /c/UBS/CW/demo/cw-demo (feature-a)
$ git push
Enumerating objects: 23, done.
Counting objects: 100% (23/23), done.
Delta compression using up to 8 threads
Compressing objects: 100% (7/7), done.
Writing objects: 100% (12/12), 889 bytes | 127.00 KiB/s, done.
Total 12 (delta 3), reused 0 (delta 0)
remote: Resolving deltas: 100% (3/3), completed with 3 local objects.
To https://github.com/debashishbarik/cw-demo.git
   e11d655..d957c95  feature-a -> feature-a

debashish.barik@M5-L-HZ2CFW2 MINGW64 /c/UBS/CW/demo/cw-demo (feature-a)
$ git status
On branch feature-a
Your branch is up to date with 'origin/feature-a'.

nothing to commit, working tree clean

debashish.barik@M5-L-HZ2CFW2 MINGW64 /c/UBS/CW/demo/cw-demo (feature-a)
