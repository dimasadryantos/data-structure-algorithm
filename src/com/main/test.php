int i = 1, num = 1
result = ""
while i <= x
	int count = 0

	for num = i; num >=1; num--
		if i % num == 0
			count += 1
		endif

	endfor
	if count == 2
		result += i + " "
	endif
	i++
END WHILE
print(result)



isPalindrome(String value, int i)
if (i < value.length / 2)
	int awal = i
	int akhir = value.length - i - 1

	if value[awal] != value[akhir]
		return false
	else
		return isPalindrome(value, i+1)
	endif
else
	return true
endif

findAllPairs(arr, K)
int count = 0
for int i; i < arr.length; i++
	for int j = 1 + 1; j < arr.length; j++
		if (arr[i] + arr[j]) == K
			count++
		ENDIF
	ENDFOR
ENDFOR
print(count)