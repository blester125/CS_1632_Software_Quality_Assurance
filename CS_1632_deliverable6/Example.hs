import Test.QuickCheck

prop_symmetric :: [Int] -> [Int] -> Bool
prop_symmetric xs ys = reverse (xs ++ ys) == reverse ys ++ reverse xs

prop_commutative :: Int -> Int -> Bool
prop_commutative a b = a + b == b + a

prop_assoc_plus :: Int -> Int -> Int -> Bool
prop_assoc_plus a b c = (a + b) + c == a + (b + c)

prop_assoc_mult :: Int -> Int -> Int -> Bool
prop_assoc_mult a b c = (a * b) * c == a * (b * c)

main = do
  putStrLn("Testing Symmetric Property of reverse")
  quickCheck prop_symmetric
  putStrLn("Testing Commutative Addition")
  quickCheck prop_commutative
  putStrLn("Testing Associative Property of Addition")
  quickCheck prop_assoc_plus
  putStrLn("Testing Associative Property of Multiplication")
  quickCheck prop_assoc_mult