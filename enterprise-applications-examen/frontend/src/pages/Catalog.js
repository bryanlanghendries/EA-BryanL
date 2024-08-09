import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Container, Grid, Typography, TextField, MenuItem, FormControl, InputLabel, Select, Button, Box } from '@mui/material';
import ProductCard from "../components/ProductCard";
import { useCart } from "../context/CartContext";

const CATEGORIES = {
    Food : 'Food',
    Decor : 'Decor',
    Habitat : 'Habitat',
    Animal : 'Animal',
}

const Catalog = () => {
    const [products, setProducts] = useState([]);
    const [selectedCategory, setSelectedCategory] = useState(CATEGORIES.Food);

    const { addToCart } = useCart();

    const handleAddToCart = (item) => {
        addToCart(item);
    };

    useEffect(() => {
        const fetchProducts = async () => {
            try {
                const token = localStorage.getItem('authToken');
                const response = await axios.get(`http://localhost:8080/api/products?category=${selectedCategory}`,
                    { headers: { Authorization: `Bearer ${token}` } });
                setProducts(response.data);
            } catch (error) {
                console.error('Error fetching products:', error);
            }
        };
        fetchProducts();
    }, [selectedCategory]);

    return (
        <Container>
            <Typography variant="h4" gutterBottom>
                Product Catalog
            </Typography>

            <Box display="flex" flexDirection="row" justifyContent="space-between" alignItems="flex-start" mb={2}>

                <FormControl variant="outlined" style={{ minWidth: 200, marginBottom: '1rem' }}>
                    <InputLabel>Category</InputLabel>
                    <Select
                        value={selectedCategory}
                        onChange={(e) => setSelectedCategory(e.target.value)}
                        label="Category"
                    >
                        <MenuItem key={CATEGORIES.Food} value={CATEGORIES.Food}>
                            {CATEGORIES.Food}
                        </MenuItem>
                        <MenuItem key={CATEGORIES.Decor} value={CATEGORIES.Decor}>
                            {CATEGORIES.Decor}
                        </MenuItem>
                        <MenuItem key={CATEGORIES.Habitat} value={CATEGORIES.Habitat}>
                            {CATEGORIES.Habitat}
                        </MenuItem>
                        <MenuItem key={CATEGORIES.Animal} value={CATEGORIES.Animal}>
                            {CATEGORIES.Animal}
                        </MenuItem>

                    </Select>
                </FormControl>
            </Box>

            <Grid container spacing={3}>
                {products.length > 0 ? (
                    products.map((product) => (
                        <Grid item xs={12} sm={6} md={4} key={product.id}>
                            <ProductCard product={product} onAddToCart={handleAddToCart} />
                        </Grid>
                    ))
                ) : (
                    <Typography variant="body1">No products found</Typography>
                )}
            </Grid>
        </Container>
    );
};

export default Catalog;
