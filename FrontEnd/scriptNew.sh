# shellcheck disable=SC2207
#get all files in directory that have inp as an extenstion
files=($(find . -type f -regex ".*\.input"))

# shellcheck disable=SC2207
sortedFiles=( $(for arr in "${files[@]}" #sort the files so it will run in order
do
    echo $arr
done | sort) )

#restore database files to their orginal contents
cp $PWD/good_items.txt $PWD/items.txt
cp $PWD/good_accounts.txt $PWD/accounts.txt

#loop through all the sorted files
for i in "${sortedFiles[@]}";
do
  base=${i##*/} #variable for the file
  baseName="$(basename  $(dirname $i))" #varaible for the base folder
  testCase=${base%.*} # variable for the file without extenstion

  echo -e "Running Test: \033[1;30m$testCase\033[21m" #show which files are running

  #run the program with io rediroction ( inputs from the input folder and output to the outputfolder )
  cmake-build-debug/FrontEnd accounts.txt items.txt  $PWD/transactions/output/$testCase.atf < "$i"
done