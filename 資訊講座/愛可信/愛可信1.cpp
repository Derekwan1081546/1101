#include <iostream>
using namespace std;
void getmax(int* array, int size)
{
	int i, j;
	int* max = new int[size];
	for (i = 0; i < size; i++)
		max[i] = 0;
	//��Ʋդ��������i��count
	for (i = 0; i < size; i++)
	{
		for (j = i; j < size; j++)
		{
			if (array[i] == array[j])
				max[i]++;
		}
	}
	//���X�Ʋդ��������̤j��
	int m = 0;
	for (i = 0; i < size; i++)
	{
		if (max[m] < max[i])
			m = i;
	}
	cout << array[m] << '\n';
	if (max[m] < (size / 2))
		cout << "�X�{���Ƴ̦h�������X�{�֩󤸯��o�@�b!" << '\n';
	cout << "�X�{���Ƭ�:" << max[m] << '\n';
	delete[] max;
}
int main()
{
	int n, x = 0;
	string a;
	cin >> a;
	int b;
	int* array;
	n = a.size();
	array = new int[n];
	for (int i = 0; i < a.size(); i++)
	{
		if (a[i] > 47 && a[i] < 58)
		{
			b = a[i] - '0';
			array[x] = b;
			x++;
		}
	}
	getmax(array, x);
	delete[] array;
	return 0;
}