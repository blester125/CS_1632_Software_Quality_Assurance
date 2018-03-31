import Prelude hiding (lookup)
import Control.Applicative
import Test.QuickCheck 
import Test.QuickCheck.Function
import System.Random
import qualified Data.Set as Set
import Data.Set (Set)
import Data.Maybe

-- Data strucure for the BST
data BST a = Empty | Node (BST a) a (BST a) deriving (Eq, Show)

-- Code to generate Arbitrary BSTs that are valid
instance (Ord a, Bounded a, Random a, Num a, Arbitrary a) => Arbitrary (BST a)  where
   arbitrary = gen 0 100 where
      gen :: (Ord a, Num a, Random a) => a -> a -> Gen (BST a)
      gen min max | (max - min) <= 3 = return Empty
      gen min max = do
        elt <- choose (min, max)
        frequency [ (1, return Empty), 
                    (6, liftA3 Node (gen min (elt - 1)) 
                            (return elt) (gen (elt + 1) max)) ] 

-- Method that check if a BST is vaild that is all elements in the left subtree
-- are smaller than the elements in the right subtree
validBST :: Ord a => BST a -> Bool
validBST tree = validBST' Nothing Nothing tree
  where validBST' lower upper Empty = True
        validBST' lower upper (Node l x r) = 
            maybeBounded lower upper x &&
            validBST' lower (Just x) l && 
            validBST' (Just x) upper r
        maybeBounded Nothing Nothing x = True
        maybeBounded Nothing (Just upper) x = x < upper
        maybeBounded (Just lower) Nothing x = lower < x
        maybeBounded (Just lower) (Just upper) x = lower < x && x < upper

-- Method to insert an elemnt into a BST
insert :: (Ord a) => a -> BST a -> BST a
insert x Empty = Node Empty x Empty
insert x (Node l y r) | x < y  = Node (insert x l) y r
                      | x == y = Node l y r
                      | x > y  = Node l y (insert x r)

-- Method to delete an element from a BST if it is there
delete :: (Ord a) => a -> BST a -> BST a
delete x Empty = Empty
delete x (Node l y r) 
  | x < y  = Node (delete x l) y r
  | x > y  = Node l y (delete x r)
  | x == y = case (l,r) of
               (Empty, _) -> r
               (l, Empty) -> l
               _          -> let (min, r') = deleteMin r in
                             Node l min r'
  where deleteMin Empty = error "nope"
        deleteMin (Node Empty x r) = (x,r)
        deleteMin (Node l x r) = 
          let (min, l') = deleteMin l in
          (min, Node l' x r)

lookup :: (Ord a) => a -> BST a -> Maybe a
lookup _ Empty = Nothing
lookup v (Node l x r)
  | v < x  = v `lookup` l
  | v == x = Just x
  | v > x  = v `lookup` r          

-- Test if the BST is valid
prop_allValid :: BST Int -> Bool
prop_allValid = validBST

-- Test look up and insert
prop_insertLookup :: Int -> BST Int -> Bool
prop_insertLookup x t = isJust $ lookup x $ insert x t

-- Test if insertion matains the BST property
prop_insertValid :: Int -> BST Int -> Bool
prop_insertValid x t = validBST $ insert x t

-- Test if the deletion leaves a vaild BST
prop_deleteValidBST :: BST Int -> Int -> Bool
prop_deleteValidBST b x = validBST $ delete x b

-- Test if the delete function actually deletes 
prop_deleteWorks :: BST Int -> Int -> Bool
prop_deleteWorks b x = isNothing $ lookup x $ delete x b


main = do
  putStrLn("Testing if the generated trees are valid BSTs.")
  quickCheck prop_allValid
  putStrLn("Testing the insertLookup.")
  quickCheck prop_insertLookup
  putStrLn("Testing if the insert keeps the tree valid.")
  quickCheck prop_insertValid
  putStrLn("Testing if the delete leaves a BST.")
  quickCheck prop_deleteValidBST
  putStrLn("Testing if the delete works.")
  quickCheck prop_deleteWorks                       