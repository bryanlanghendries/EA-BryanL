import React from 'react';
import { Container, Typography, Button, Box } from '@mui/material';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <Container sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', padding: 4 }}>
            <Box
                sx={{
                    textAlign: 'center',
                    padding: 6,
                    borderRadius: 2,
                    boxShadow: 3,
                    border: '1px solid #f4a261',
                    marginBottom: 4,
                }}
            >
                <Typography variant="h2" component="h1" gutterBottom>
                    Welcome to Paws & Claws Pet Shop!
                </Typography>
                <Typography variant="h5" paragraph>
                    Discover a wide range of products and accessories for your beloved pets. From cozy beds to nutritious food, we have everything to keep your furry friends happy and healthy.
                </Typography>
                <Link to="/catalog" style={{ textDecoration: 'none' }}>
                    <Button variant="contained" color="secondary" size="large">
                        Explore Our Catalog
                    </Button>
                </Link>
            </Box>
            <Typography variant="h6" paragraph align="center">
                We offer high-quality pet supplies including food, toys, grooming products, and more. Shop now and give your pets the best they deserve!
            </Typography>
        </Container>
    );
};

export default Home;
