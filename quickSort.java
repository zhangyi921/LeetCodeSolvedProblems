import java.util.Arrays;

public class test {

	static int[] a = {2,2, 4, 1, 6, 3, 8, -1, 9, -5, 10, 7, -2};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		// quick sort
		quickSort(0, a.length-1);
		
		System.out.println(Arrays.toString(a));
	}
	
	public static void quickSort(int start, int end) {

		if (start == end)
			return;
		// pivot is always the last item
		// cur always points to current item
		// toBeSwapped starts at start item
		// if cur < pivot, toBeSwapped will be swapped
		int pivot = a[end], cur = start, temp, toBeSwapped = start;
		for (; cur < end; ++cur) {
			if (a[cur] < pivot) {
				// swap start and cur
				temp = a[cur];
				a[cur] = a[toBeSwapped];
				a[toBeSwapped] = temp;
				++toBeSwapped;
			}
			
		}
		// swap start and pivot
		a[end] = a[start];
		a[start] = pivot;
		// if toBeSwapped still points to the start item
		// first half doesn't minus 1, second half plus 1
		// otherwise first half minus 1, second half doesn't plus 1
		quickSort(start, toBeSwapped==start?start:toBeSwapped-1);
		quickSort(toBeSwapped==start?toBeSwapped+1:toBeSwapped, end);
		
	}

}
