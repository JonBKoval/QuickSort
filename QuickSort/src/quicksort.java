import java.util.Random;

public class quicksort {
	private static int[] array = new int[15];
	
	// Main Section
	public static void main(String[] args) {
		initArray(array);
		System.out.println("Unsorted array: ");
		print(array);
		final stopwatch timer = new stopwatch();
		quickSort(array, 0, (array.length - 1));
		System.out.printf("Total Time: %f\n", timer.elapsedTime());
		System.out.println("Sorted array: ");
		print(array);
	}
	
	// Print function
	public static void print(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.printf("%d", array[i]);
			if(i == array.length - 1){
				System.out.printf("\n");
			}
			else{
				System.out.printf(", ");
			}
		}
	}
	
	// Generates a random array
	// rand.nextInt((Value)); Value specifies range of random number
	public static void initArray(int[] array){
		Random rand = new Random();
		
		for(int i = 0; i < array.length; i++){
			array[i] = rand.nextInt((100));
		}
	}

	// Partitions values smaller then the pivot value to the left and
	// anything larger to the right of the pivot value
	public static int partition(int array[], int left, int right){
		int i = left;
		int j = right;
		int temp;
		int pivot = array[(left + right) / 2];
	     
		while (i <= j) {
			while (array[i] < pivot){
				i++;
			}
			while (array[j] > pivot){          
				j--;
			}
			if (i <= j) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}

	// Recursive quick sort
	public static void quickSort(int array[], int left, int right){      
		int index = partition(array, left, right);
		if (left < index - 1){
			quickSort(array, left, index - 1);
		}
		if (index < right){
			quickSort(array, index, right);
		}
	}
}
