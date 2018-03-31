import Test.QuickCheck
import Data.List
-- Sorts 

-- Quick Sort a classis haskell sort
quickSort :: (Ord a) => [a] -> [a]
quickSort [] = []
quickSort (x:xs) = quickSort smaller ++ [x] ++ quickSort larger
  where
    smaller = [a | a <- xs, a <= x]
    larger = [a | a <- xs, a > x]

-- merge routine for merge sort
merge :: (Ord a) => [a] -> [a] -> [a]
merge [] xs = xs
merge xs [] = xs
merge (x:xs) (y:ys)
  | (x < y) = x:merge xs (y:ys)
  | otherwise = y:merge (x:xs) ys

-- routine to split list into two halves
split :: [a] -> ([a], [a])
split xs = (take n xs, drop n xs)
  where n = (length xs) `div` 2

-- Merge Sort
mergeSort :: (Ord a) => [a] -> [a]
mergeSort xs
  | (length xs) > 1 = merge (mergeSort ls) (mergeSort rs)
  | otherwise = xs
  where (ls, rs) = split xs
    
-- swapping routine for bubble sort 
bubbleSort'iter :: (Ord a) => [a] -> [a]
bubbleSort'iter (x:y:xs)
    | x > y = y : bubbleSort'iter (x:xs)
    | otherwise = x : bubbleSort'iter (y:xs)
bubbleSort'iter (x) = (x)

-- run bubble sort until i == length of list
bubbleSort' :: (Ord a) => [a] -> Int -> [a]
bubbleSort' xs i 
    | i == (length xs) = xs
    | otherwise = bubbleSort' (bubbleSort'iter xs) (i + 1) 
 
-- Bubble Sort function
bubbleSort :: (Ord a) => [a] -> [a]
bubbleSort xs = bubbleSort' xs 0

-- Tests

-- Test that calling the function on the output of the 
-- function doesn't change it
prop_idempotent_qs :: [Int] -> Bool
prop_idempotent_qs xs = quickSort (quickSort xs) == quickSort xs

prop_idempotent_ms :: [Int] -> Bool
prop_idempotent_ms xs = mergeSort (mergeSort xs) == mergeSort xs

prop_idempotent_bs :: [Int] -> Bool
prop_idempotent_bs xs = bubbleSort (bubbleSort xs) == bubbleSort xs

-- Test that all the elements are in order
prop_order_qs :: [Int] -> Bool
prop_order_qs xs = ordered (quickSort xs)
  where ordered [] = True
        ordered [x] = True
        ordered (x:y:xs) = x <= y && ordered xs

prop_order_ms :: [Int] -> Bool
prop_order_ms xs = ordered (mergeSort xs)
  where ordered [] = True
        ordered [x] = True
        ordered (x:y:xs) = x <= y && ordered xs

prop_order_bs :: [Int] -> Bool
prop_order_bs xs = ordered (bubbleSort xs)
  where ordered [] = True
        ordered [x] = True
        ordered (x:y:xs) = x <= y && ordered xs

-- Test that the smallest element is at the front of the list
prop_minimum_qs :: [Int] -> Property
prop_minimum_qs xs = not (null xs) ==> head (quickSort xs) == minimum xs

prop_minimum_ms :: [Int] -> Property
prop_minimum_ms xs = not (null xs) ==> head (mergeSort xs) == minimum xs

prop_minimum_bs :: [Int] -> Property
prop_minimum_bs xs = not (null xs) ==> head (bubbleSort xs) == minimum xs

-- Test that the largest element is at the end of the list
prop_maximum_qs :: [Int] -> Property
prop_maximum_qs xs = not (null xs) ==> last (quickSort xs) == maximum xs

prop_maximum_ms :: [Int] -> Property
prop_maximum_ms xs = not (null xs) ==> last (mergeSort xs) == maximum xs

prop_maximum_bs :: [Int] -> Property
prop_maximum_bs xs = not (null xs) ==> last (bubbleSort xs) == maximum xs

-- test that the output is a permutation
-- Also tests:
  -- The input and output are the same size
  -- No element in the input is missing from the output
  -- No element in the output is messing from the input
prop_permutation_qs :: [Int] -> Bool
prop_permutation_qs xs = permutation xs (quickSort xs)
    where permutation xs ys = null (xs \\ ys) && null (ys \\ xs)

prop_permutation_ms :: [Int] -> Bool
prop_permutation_ms xs = permutation xs (mergeSort xs)
    where permutation xs ys = null (xs \\ ys) && null (ys \\ xs)

prop_permutation_bs :: [Int] -> Bool
prop_permutation_bs xs = permutation xs (bubbleSort xs)
    where permutation xs ys = null (xs \\ ys) && null (ys \\ xs)

-- The minimum of two lists is at the front of the appended lists when sorted
prop_append_qs :: [Int] -> [Int] -> Property
prop_append_qs xs ys =
    not (null xs) ==>
    not (null ys) ==>
        head (quickSort (xs ++ ys)) == min (minimum xs) (minimum ys)

prop_append_ms :: [Int] -> [Int] -> Property
prop_append_ms xs ys =
    not (null xs) ==>
    not (null ys) ==>
        head (mergeSort (xs ++ ys)) == min (minimum xs) (minimum ys)

prop_append_bs :: [Int] -> [Int] -> Property
prop_append_bs xs ys =
    not (null xs) ==>
    not (null ys) ==>
        head (bubbleSort (xs ++ ys)) == min (minimum xs) (minimum ys)

-- The sort produces the same result as the built in sort
prop_model_qs :: [Int] -> Bool
prop_model_qs xs = Data.List.sort xs == quickSort xs

prop_model_ms :: [Int] -> Bool
prop_model_ms xs = Data.List.sort xs == mergeSort xs

prop_model_bs :: [Int] -> Bool
prop_model_bs xs = Data.List.sort xs == bubbleSort xs

--Main
main = do
  putStrLn("Testing Idempotence:")
  putStrLn("\tQuick Sort")
  quickCheck prop_idempotent_qs
  putStrLn("\tMerge Sort")
  quickCheck prop_idempotent_ms
  putStrLn("\tBubble Sort")
  quickCheck prop_idempotent_bs

  putStrLn("Testing Order:")
  putStrLn("\tQuick Sort")
  quickCheck prop_order_qs
  putStrLn("\tMerge Sort")
  quickCheck prop_order_ms
  putStrLn("\tBubble Sort")
  quickCheck prop_order_bs

  putStrLn("Testing Minimum:")
  putStrLn("\tQuick Sort")
  quickCheck prop_minimum_qs
  putStrLn("\tMerge Sort")
  quickCheck prop_minimum_ms
  putStrLn("\tBubble Sort")
  quickCheck prop_minimum_bs

  putStrLn("Testing Maximum:")
  putStrLn("\tQuick Sort")
  quickCheck prop_maximum_qs
  putStrLn("\tMerge Sort")
  quickCheck prop_maximum_ms
  putStrLn("\tBubble Sort")
  quickCheck prop_maximum_bs
  
  putStrLn("Testing Permutation:")
  putStrLn("\tQuick Sort")
  quickCheck prop_permutation_qs
  putStrLn("\tMerge Sort")
  quickCheck prop_permutation_ms
  putStrLn("\tBubble Sort")
  quickCheck prop_permutation_bs

  putStrLn("Testing Appended Lists:")
  putStrLn("\tQuick Sort")
  quickCheck prop_append_qs
  putStrLn("\tMerge Sort")
  quickCheck prop_append_ms
  putStrLn("\tBubble Sort")
  quickCheck prop_append_bs

  putStrLn("Testing Model:")
  putStrLn("\tQuick Sort")
  quickCheck prop_model_qs
  putStrLn("\tMerge Sort")
  quickCheck prop_model_ms
  putStrLn("\tBubble Sort")
  quickCheck prop_model_bs