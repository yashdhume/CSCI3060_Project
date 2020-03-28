# shellcheck disable=SC2207
#get all files in directory that have inp as an extenstion
files=($(find . -type f -regex ".*\.inp"))

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
  cmake-build-debug/FrontEnd accounts.txt items.txt  $PWD/tests/transactions/$baseName/transaction_$testCase.atf < "$i" > $PWD/tests/output/$baseName/$testCase.out

  #if the output test case and transaction test case exisits t
  if [ -e $PWD/tests/output/$baseName/$testCase.out ] && [ -e $PWD/tests/transactions/$baseName/transaction_$testCase.atf ];
  then
    #diffence between expected output and the output and IO redirect to difference ouput folder
    diff $PWD/tests/output/$baseName/$testCase.out $PWD/tests/expectedoutput/$baseName/$testCase.exout > $PWD/tests/differenceoutput/$baseName/$testCase.diffout
    diff -e $PWD/tests/transactions/$baseName/transaction_$testCase.atf $PWD/tests/expectedtransactions/$baseName/transaction_$testCase.atf> $PWD/tests/differencetransaction/$baseName/transaction_$testCase.diffatf
  fi

  #check if difference outputs are empty and print successful or not in green and red
  [[ -s $PWD/tests/differenceoutput/$baseName/$testCase.diffout ]] && echo -e "\033[1;31m$testCase test case was unsuccessful\033[0m" || echo -e "\033[1;32m$testCase test case was successful\033[0m"
  [[ -s $PWD/tests/differencetransaction/$baseName/transaction_$testCase.diffatf ]] && echo -e "\033[1;31m$testCase transaction was unsuccessful\033[0m" || echo -e "\033[1;32m$testCase transaction was successful\033[0m"

done