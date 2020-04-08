# shellcheck disable=SC2207
#DAILY SCRIPT
#get all files in directory that have inp as an extenstion
files=($(find FrontEnd . -type f -regex ".*\.input"))

# shellcheck disable=SC2207
sortedFiles=( $(for arr in "${files[@]}" #sort the files so it will run in order
do
    echo $arr
done | sort) )

#restore database files to their orginal contents
cp $PWD/FrontEnd/good_items.txt $PWD/FrontEnd/items.txt
cp $PWD/FrontEnd/good_accounts.txt $PWD/FrontEnd/accounts.txt

#loop through all the sorted files
for i in "${sortedFiles[@]}";
do
  base=${i##*/} #variable for the file
  baseName="$(basename  $(dirname $i))" #variable for the base folder
  testCase=${base%.*} # variable for the file without extension

  echo -e "Running Test: \033[1;30m$testCase\033[21m" #show which files are running

  #run the program with io redirection ( inputs from the input folder and output to the outputfolder )
  ./FrontEnd/FrontEnd FrontEnd/accounts.txt FrontEnd/items.txt  $PWD/FrontEnd/transactions/output/$testCase.atf < "$i"
done

#get all atf filess
filesATF=($(find FrontEnd . -type f -regex ".*\.atf"))

sortedATF=( $(for arr in "${filesATF[@]}" #sort them
	do
		echo $arr
	done | sort
	))

#merging files
cat "${sortedATF[@]}" > mergedDailyTransactions.atf

#Run the backend with the new mergedDailyTransactions.atf

arg1=$PWD/FrontEnd/items.txt
arg2=$PWD/FrontEnd/accounts.txt
arg3=$PWD/mergedDailyTransactions

dir=$PWD/BackEnd/

java -jar $dir/BackEnd.jar arg1 arg2 arg3