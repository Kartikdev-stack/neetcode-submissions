class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        original=image[sr][sc]

        if original==color:
            return image
        
        self.dfs(image, sr, sc, original, color)
        return image


    def dfs(self, image: List[List[int]], sr: int, sc: int, og: int, color:int) -> None:
        if sr<0 or sr>=len(image) or sc<0 or sc>=len(image[0]) or image[sr][sc]!=og:
            return
        
        image[sr][sc]=color
        
        # exploring directions
        self.dfs(image, sr+1, sc,og, color)
        self.dfs(image, sr-1, sc,og, color)
        self.dfs(image, sr, sc+1,og, color)
        self.dfs(image, sr, sc-1,og, color)
