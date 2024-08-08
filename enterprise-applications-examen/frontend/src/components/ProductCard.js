import { Card, CardContent, Typography, Button, Box } from '@mui/material';

function ProductCard({ product, onAddToCart }) {
    return (
        <Card sx={{ maxWidth: 345, margin: 2, boxShadow: 3 }}>
            <CardContent>
                <Typography variant="h5" component="div" gutterBottom>
                    {product.name}
                </Typography>
                <Typography variant="body2" color="text.secondary" gutterBottom>
                    Category: {product.category}
                </Typography>
                <Typography variant="body2" color="text.secondary" gutterBottom>
                    {product.description}
                </Typography>
                <Typography variant="h6" color="primary" sx={{ marginTop: 1 }}>
                    ${product.price.toFixed(2)}
                </Typography>
                <Box sx={{ display: 'flex', justifyContent: 'flex-end', marginTop: 2 }}>
                    <Button
                        variant="contained"
                        color="primary"
                        onClick={() => onAddToCart(product)}
                    >
                        Add to Cart
                    </Button>
                </Box>
            </CardContent>
        </Card>
    );
}

export default ProductCard;
